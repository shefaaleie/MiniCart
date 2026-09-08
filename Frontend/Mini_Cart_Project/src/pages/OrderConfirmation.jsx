import React from 'react'
import { useNavigate } from 'react-router-dom'


const OrderConfirmation = () => {

        const navigate = useNavigate()

  return (
    <div className='min-h-screen flex justify-center items-center bg-pink-50'>

            <div className='bg-white p-10 rounded-xl shadow-lg text-center w-96'>

                <div className='text-6xl mb-5'>
                    🎉
                </div>

                <h1 className='text-3xl font-bold mb-4'>
                    Order Placed Successfully!
                </h1>

                <p className='text-gray-500 mb-8'>
                    Thank you for shopping with MiniCart 💕
                    Your order has been confirmed successfully.
                </p>

                <button
                    onClick={() => {
                                               navigate('/')

                    }}
                    className='bg-red-400 text-white px-6 py-3 rounded-lg hover:bg-red-500'
                >
                    Continue Shopping
                </button>

            </div>

        </div>
    )
  
}

export default OrderConfirmation
