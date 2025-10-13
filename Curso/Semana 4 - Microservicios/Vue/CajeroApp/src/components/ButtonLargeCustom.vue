<script setup lang="ts">
    defineProps<{
        text?: string;
        disabled?: boolean;
        colorSquare?: String;
        onClick?: (parametro?: any) => void;
    }>()
</script>

<template>
    <button 
        type="button" 
        @click="onClick" 
        :disabled="disabled"
        :class="`ml-5 size-22 grow flex px-2 items-center rounded inset-shadow
            ${disabled ? 'bg-gray-400 dark:bg-gray-600 cursor-not-allowed' 
            : 'bg-gray-300 dark:bg-gray-400  hover:bg-gray-400/75 dark:hover:bg-gray-500 cursor-pointer'}`">
        <div class="size-22 content-center text-black uppercase flex-1 text-lg font-medium">{{ text }}</div>
        <div :class="`size-18 content-center ${colorSquare || 'bg-white'} text-black rounded`"></div>

    </button>
</template>