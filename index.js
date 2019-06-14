import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Homeportal from '@/components/Homeportal'
import SuperSearch from '@/components/SuperSearch'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/homeportal',
      name: 'homeportal',
      component: Homeportal
    },
    {
      path: '/superSearch',
      name: 'superSearch',
      component: SuperSearch
    }
  ]
})
