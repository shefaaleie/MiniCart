// import React from 'react'

import axios from "axios"
import { useEffect, useState } from "react"
import { useNavigate } from 'react-router-dom'


const CheckoutPage = () => {

    const navigate = useNavigate()

    const [grandTotal, setGrandTotal] = useState(0)

    const [customerName, setCustomerName] = useState("")
    const [phoneNumber, setphoneNumber] = useState("")
    const [address, setAddress] = useState("")

    const [data, setData] = useState('')



    const getGrandTotal = async () => {
        const response = await axios.get(`http://localhost:8080/api/cart/getGrandTotal`)
        console.log(response.data)
        setGrandTotal(response.data)
    }

    const formSubmitHandler = async (e) => {
        e.preventDefault()
        const orderData = {
            CustomerName: customerName,
            PhoneNumber: phoneNumber,
            Address: address,
            GrandTotal: grandTotal
        }

        const response = await axios.post(`http://localhost:8080/api/order/create`, orderData)
        console.log(response.data);
        setData(response.data)


    }

    useEffect(() => {
        getGrandTotal()
        setData()
    }, [])


    return (
        <div className='p-10'>

            {/* Heading */}

            <h1 className='text-3xl font-bold text-center mb-10'>
                Checkout 🛍️
            </h1>




            <form className='flex gap-10' onSubmit={(e) => {

                formSubmitHandler(e)
                console.log("formSubmitted by:", customerName, phoneNumber, address)
            }}>



                {/* Customer Details */}

                <div className='w-2/3 bg-pink-100 p-8 rounded'>

                    <h2 className='text-2xl font-bold mb-6'>
                        Customer Details
                    </h2>


                    {/* Name */}

                    <div className='mb-5'>

                        <label className='block mb-2'>
                            Full Name
                        </label>

                        <input
                            type='text'
                            placeholder='Enter your name'
                            className='w-full p-3 rounded border'
                            value={customerName}
                            onChange={(e) => {
                                setCustomerName(e.target.value)
                            }}
                        />

                    </div>


                    {/* Phone */}

                    <div className='mb-5'>

                        <label className='block mb-2'>
                            Phone Number
                        </label>

                        <input
                            type='text'
                            placeholder='Enter your phone number'
                            className='w-full p-3 rounded border'
                            value={phoneNumber}
                            onChange={(e) => {
                                setphoneNumber(e.target.value)
                            }}
                        />

                    </div>


                    {/* Address */}

                    <div className='mb-5'>

                        <label className='block mb-2'>
                            Address
                        </label>

                        <textarea
                            placeholder='Enter your address'
                            className='w-full p-3 rounded border h-28'
                            value={address}
                            onChange={(e) => {
                                setAddress(e.target.value)
                            }}
                        />

                    </div>

                </div>


                {/* Order Summary */}

                <div className='w-1/3 bg-pink-200 p-6 rounded h-fit'>

                    <h2 className='text-2xl font-bold mb-6'>
                        Order Summary
                    </h2>


                    <div className='flex justify-between mb-4'>

                        <span>Subtotal</span>

                        <span>₹ {grandTotal}</span>

                    </div>


                    <hr />


                    <div className='flex justify-between mt-4 text-xl font-bold'>

                        <span>Total</span>

                        <span>₹ {grandTotal}</span>

                    </div>


                    <button onClick={() => {
                        navigate('/orderConfirm')
                    }} className='w-full bg-red-400 text-white p-3 rounded mt-6'>
                        Place Order
                    </button>

                </div>
            </form>



        </div>
    )
}

export default CheckoutPage