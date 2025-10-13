<script setup lang="ts">
    defineProps<{
        text: string;
        disabled?: boolean;
        onClick?: (parametro?: any) => void;
    }>()
</script>

<template>
    <button 
        type="button" 
        @click="onClick" 
        :disabled="disabled"
        :class="`size-22 content-center inset-shadow text-black rounded text-2xl 
            ${disabled ? 'bg-gray-400 dark:bg-gray-600 cursor-not-allowed' 
            : 'bg-gray-300 dark:bg-gray-400  hover:bg-gray-400/75 dark:hover:bg-gray-500 cursor-pointer'}`">
        {{ text }}

    </button>
</template>