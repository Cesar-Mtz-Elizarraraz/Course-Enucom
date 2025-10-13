import axios from 'axios'
import type { RetiroForm, RetiroResponse } from "../interfaces/DineroResponse"

const API_BASE_URL = import.meta.env.VITE_API_URL

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
})

export const apiService = {
  obtenerFondos() {
    return api.get<number>('/cajero/fondos')
  },

  retirarDinero(data: RetiroForm) {
    return api.post<RetiroResponse[]>('/cajero/retiro', data)
  }
}
