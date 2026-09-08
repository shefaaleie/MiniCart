import React from 'react'
import NavBar from './components/NavBar'
import Home from './pages/Home'
import CartPage from './pages/CartPage'
import { Route, Routes } from 'react-router-dom'
import CheckoutPage from './pages/CheckOutPage'
import OrderConfirmation from './pages/OrderConfirmation'

const App = () => {
  return (
    <div>
      <NavBar />
<Routes>

<Route path='/' element={<Home />}></Route>
<Route path='/cart' element={<CartPage />}></Route>
<Route path='/checkOut' element={<CheckoutPage />}></Route>
<Route path='/orderConfirm' element={<OrderConfirmation />}></Route>


</Routes>

      
    </div>
  )
}

export default App
App
