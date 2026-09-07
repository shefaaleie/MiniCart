import React from 'react'
import { FaCartShopping } from "react-icons/fa6";
import {Link} from 'react-router-dom'

const NavBar = () => {
  return (
    <div className='flex justify-between py-4 px-7 bg-purple-300 '>
      <h2 className='flex gap-1 items-center'> <FaCartShopping />MiniCart</h2>
      <div className='flex gap-5'>

       
        <Link to='/'>Home</Link>
        <Link to='/cart'>Cart</Link>
      </div>
    </div>
  )
}

export default NavBar
