<template>
  <div class="flex flex-col items-center">
    <div class="overflow-x-auto gap-5 flex flex-col select-none w-150">
      <h1 class="text-3xl font-bold">CAJERO AUTOMÁTICO</h1>
      <div class="relative w-full h-75 flex flex-col bg-gray-700 dark:bg-gray-200 rounded border-4 border-gray-800 dark:border-gray-600 text-white dark:text-black">
        <div class="absolute inset-0 bg-gray-900/75 dark:bg-black/75 z-10 content-center" v-if="screenLoad">
          <span class="opacity-100 font-bold text-white"><font-awesome-icon icon="fa-solid fa-spinner" spin class="mr-1" />Cargando...</span>
        </div>
        <div class="flex-1 content-center text-2xl">
          <div class="uppercase italic mb-3">
            Ingrese la cantidad a retirar
          </div> 
          <span class="text-4xl font-medium">${{ cantidadPantalla }}</span>
          
        </div>
        <div class="text-red-400 dark:text-red-700">
          {{ errorMessage }}&emsp;
        </div>
      </div>
      
      <div class="flex gap-5">
        <ButtonCustom text="1" :onClick="() => generarCantidad(1)" :disabled="disabledButton" />
        <ButtonCustom text="2" :onClick="() => generarCantidad(2)" :disabled="disabledButton" />
        <ButtonCustom text="3" :onClick="() => generarCantidad(3)" :disabled="disabledButton" />
        <ButtonLargeCustom text="CANCELAR" :onClick="cancelar" :disabled="disabledButton" colorSquare="bg-red-500" />
      </div>
      <div class="flex gap-5">
        <ButtonCustom text="4" :onClick="() => generarCantidad(4)" :disabled="disabledButton" />
        <ButtonCustom text="5" :onClick="() => generarCantidad(5)" :disabled="disabledButton" />
        <ButtonCustom text="6" :onClick="() => generarCantidad(6)" :disabled="disabledButton" />
        <ButtonLargeCustom text="CORREGIR" :onClick="corregir" :disabled="disabledButton" colorSquare="bg-yellow-500" />
      </div>
      <div class="flex gap-5">
        <ButtonCustom text="7" :onClick="() => generarCantidad(7)" :disabled="disabledButton" />
        <ButtonCustom text="8" :onClick="() => generarCantidad(8)" :disabled="disabledButton" />
        <ButtonCustom text="9" :onClick="() => generarCantidad(9)" :disabled="disabledButton" />
        <ButtonLargeCustom :onClick="reiniciar" :disabled="disabledButton || dineroRetirado ? false : true" />
      </div>
      <div class="flex gap-5">
        <ButtonCustom text=".50" :onClick="toggleCentavos" :disabled="disabledButton" />
        <ButtonCustom text="0" :onClick="() => generarCantidad(0)" :disabled="disabledButton" />
        <ButtonCustom text="000" :onClick="generarMiles" :disabled="disabledButton" />
        <ButtonLargeCustom text="ACEPTAR" :onClick="aceptar" :disabled="disabledButton" colorSquare="bg-green-800" />
      </div>
      <span class="font-bold text-3xl" v-if="dineroRetirado">DINERO ENTREGADO</span>
    </div>
    <div class="flex flex-wrap gap-5 items-center w-full mt-5 justify-center" v-if="dineroRetirado">
      <div class="flex gap-5 items-center" v-for="dinero in dineroRetirado">
        <img :src="`/images/dinero_${dinero.denominacion?.toString().replace('.', '_') || ''}.png`" :alt="`$${dinero.denominacion}`" :class="dinero.tipo === 'Billete' ? 'w-90' : 'w-25'" />
        <span class="font-bold text-3xl">x{{ dinero.cantidad }}</span>
      </div>
    </div>
  </div>
  

</template>
<script lang="ts" setup>
  import { ref, watch, onMounted } from 'vue'
  import ButtonCustom from '../components/ButtonCustom.vue'
  import ButtonLargeCustom from '../components/ButtonLargeCustom.vue'
  import { apiService } from '../service/apiService'
  import type { AxiosError } from 'axios'
  import type { RetiroForm, RetiroResponse } from '../interfaces/DineroResponse'
  
  const cantidad = ref('0.00')
  const cantidadPantalla = ref('0.00')
  const errorMessage = ref('')
  const screenLoad = ref(false)
  const dineroRetirado = ref<RetiroResponse[] | null>(null)
  const disabledButton = ref(false)
  let fondosDisponibles = 0
  const MONTO_MAXIMO = 12000

  watch(cantidadPantalla, () => {
    errorMessage.value = ""
  })

  onMounted(() => {
    obtenerFondos()
  })

  const reiniciar = () => {
    cancelar()
    dineroRetirado.value = null
    obtenerFondos()
  }

  const obtenerFondos = async () => {
    disabledButton.value = true
    try {
      const respuesta = await apiService.obtenerFondos()
      fondosDisponibles = respuesta.data
      disabledButton.value = false
    } catch (error: any) {
      const axiosError: AxiosError = error;
      errorMessage.value = JSON.stringify(axiosError.response?.data || "Ocurrió un error al obtener los fondos").replace(/^"|"$/g, '')
    }
  }

  const retirar = async (data: RetiroForm) => {
    screenLoad.value = true
    disabledButton.value = true
    try {
      const respuesta = await apiService.retirarDinero(data)
      console.log(respuesta)
      setTimeout(() => {
        screenLoad.value = false
        dineroRetirado.value = respuesta.data
      }, 1000)
    } catch (error: any) {
      const axiosError: AxiosError = error;
      setTimeout(() => {
        screenLoad.value = false
         errorMessage.value = JSON.stringify(axiosError.response?.data || "Ocurrió un error al realizar el retiro").replace(/^"|"$/g, '')
      }, 1000)
    }
  }

  const generarCantidad = (value: number) => {
    let newCantidad = cantidad.value
    
    newCantidad = newCantidad.slice(0, -3)
    newCantidad = `${newCantidad}${value}`
    
    const cantidadNum = Number(newCantidad)
    newCantidad = `${cantidadNum}${withCents() ? ".50" : ".00"}`

    if(esMontoValido(newCantidad)){
      cantidad.value = newCantidad
      cantidadPantalla.value = `${cantidadNum.toLocaleString("en-US")}${withCents() ? ".50" : ".00"}`
    } else {
      errorMessage.value = `El monto máximo a retirar es de $${MONTO_MAXIMO.toLocaleString("en-US")}.00`
    }
  }

  const generarMiles= () => {
    if(!["0.00", "0.50"].includes(cantidad.value)){
      let newCantidad = cantidad.value
      newCantidad = newCantidad.slice(0, -3)
      const numCantidad = Number(`${newCantidad}000`)
      newCantidad = `${newCantidad}000${withCents() ? ".50" : ".00"}`
      if(esMontoValido(newCantidad)){
        cantidad.value = newCantidad
        cantidadPantalla.value = `${numCantidad.toLocaleString("en-US")}${withCents() ? ".50" : ".00"}`
      } else {
        errorMessage.value = `El monto máximo a retirar es de $${MONTO_MAXIMO.toLocaleString("en-US")}.00`
      }
    }
  }

  const cancelar = () => {
    cantidad.value = "0.00"
    cantidadPantalla.value  = "0.00"
    errorMessage.value = ""
  }

  const corregir = () => {
    let newCantidad = cantidad.value

    if(newCantidad === "0.50"){
      cancelar()
      return
    }

    newCantidad = newCantidad.slice(0, -3)
    let numCantidad = Number(newCantidad)
    if(numCantidad){
      newCantidad = newCantidad.slice(0, -1)
      numCantidad = Number(newCantidad)
      if(isNaN(numCantidad) || !numCantidad){
        newCantidad = "0";
        numCantidad = 0;
      }
    }
    newCantidad = `${newCantidad}${withCents() ? ".50" : ".00"}`
    cantidad.value = newCantidad
    cantidadPantalla.value = `${numCantidad.toLocaleString("en-US")}${withCents() ? ".50" : ".00"}`

  }

  const aceptar = () => {
    const numCantidad = Number(cantidad.value)
    errorMessage.value = ""
    if(isNaN(numCantidad) || !numCantidad){
      errorMessage.value = "La cantidad ingresada no es valida para el retiro"
      return
    }

    if(conFondosSuficientes(numCantidad)){
      const data = {
        monto: numCantidad
      }
      retirar(data)
    } else {
      errorMessage.value = "No hay fondos disponibles"
    }
  }

  const toggleCentavos = () => {
    const cantidadValue = cantidad.value
    if(withCents()) {
      cantidad.value = cantidadValue.replace(".50", ".00")
      cantidadPantalla.value = cantidadPantalla.value.replace(".50", ".00")
    } else {
       if(esMontoValido(cantidadValue.replace(".00", ".50"))){
        cantidad.value = cantidadValue.replace(".00", ".50")
        cantidadPantalla.value = cantidadPantalla.value.replace(".00", ".50")
      } else {
        errorMessage.value = `El monto máximo a retirar es de $${MONTO_MAXIMO.toLocaleString("en-US")}.00`
      }
      
    }
  }

  const withCents = () => {
    return cantidad.value.includes(".50")
  }

  const esMontoValido = (monto: String) => {
    const numMonto = Number(monto)
    return numMonto <= MONTO_MAXIMO
  }

  const conFondosSuficientes = (monto: number) => {
    return fondosDisponibles >= monto
  }


</script>