// src/router/index.ts
import { createRouter, createWebHistory, type RouteRecordRaw } from 'vue-router'
import Cajero from '../views/Cajero.vue'

const routes: Array<RouteRecordRaw> = [
  { path: '/cajero', name: 'Cajero', component: Cajero }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
