import axios from 'axios'
import { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'

const CartPage = () => {


    const [cartItem, setCartItem] = useState([])
    const [grandTotal, setGrandTotal] = useState(0)
    const navigate=useNavigate()

    const getData = async () => {

        const response = await axios.get(`http://localhost:8080/api/cart`)
        console.log(response.data)
        setCartItem(response.data)
    }

    const getGrandTotal = async () => {
        const response = await axios.get(`http://localhost:8080/api/cart/getGrandTotal`)
        console.log("GrandTotal=", response)
        setGrandTotal(response.data)
    }

    const increaseQuantity = async (elem) => {
        const updatedQuantity = {
            quantity: elem.quantity + 1
        }

        await axios.patch(`http://localhost:8080/api/cart/updateQuantity/${elem.cartId}`, updatedQuantity)

        getData()
        getGrandTotal()
    }

    const decreaseQuantity = async (elem) => {

        if (elem.quantity <= 1) {
            return
        }
        const updatedQuantity = {
            quantity: elem.quantity - 1
        }

        await axios.patch(`http://localhost:8080/api/cart/updateQuantity/${elem.cartId}`, updatedQuantity)

        getData()
        getGrandTotal()
    }


    const removeItem = async (elem) => {
        await axios.delete(`http://localhost:8080/api/cart/delete/${elem.cartId}`)
        getData()
        getGrandTotal()
    }

    useEffect(function () {
        getData()
        getGrandTotal()
    }, [])

    return (
        <div className='p-10'>

            {/* Heading */}

            <h1 className='text-3xl font-bold text-center mb-10'>
                My Cart 🛒
            </h1>


            {/* Main Container */}

            <div className='flex gap-10'>

                {/* Cart Items */}

                <div className='w-2/3'>

                    {
                        cartItem.length == 0 ? (
                            <div className='flex flex-col items-center justify-center py-20'>

                                <div className='text-6xl mb-5'>
                                    🛒
                                </div>

                                <h2 className='text-3xl font-bold mb-3'>
                                    Your Cart is Empty
                                </h2>

                                <p className='text-gray-500 mb-6'>
                                    Looks like you haven't added anything to your cart yet!
                                </p>

                            </div>
                        ) : (
                            
                                cartItem.map(function (elem) {
                                    return <div key={elem.cartId} className='flex items-center gap-6 bg-pink-100 p-5 rounded mb-5'>

                                        {/* Image */}

                                        <img
                                            src={`/images/${elem.product.image}`}
                                            alt=''
                                            className='w-32 h-32 object-cover bg-white rounded'
                                        />


                                        {/* Product Details */}

                                        <div className='flex-1'>

                                            <h2 className='text-xl font-semibold'>
                                                {elem.product.productName}
                                            </h2>

                                            <p className='mt-2'>
                                                ₹{elem.product.price}
                                            </p>

                                        </div>


                                        {/* Quantity */}

                                        <div className='flex items-center gap-3'>

                                            <button onClick={() => {
                                                decreaseQuantity(elem)
                                            }} className='bg-white px-3 py-1 rounded'>
                                                -
                                            </button>

                                            <span>
                                                {elem.quantity}
                                            </span>

                                            <button onClick={() => {
                                                increaseQuantity(elem)
                                            }} className='bg-white px-3 py-1 rounded'>
                                                +
                                            </button>

                                        </div>


                                        {/* Remove */}

                                        <button onClick={() => {
                                            removeItem(elem)
                                        }} className='bg-red-400 text-white px-4 py-2 rounded'>
                                            Remove
                                        </button>

                                    </div>
                                })
                            



                        )
                    }

                    {/* Cart Item */}










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


                    <button onClick={()=>{
                        navigate('/checkOut')
                    }} className='w-full bg-red-400 text-white p-3 rounded mt-6'>
                        Checkout
                    </button>



                </div>

            </div>

        </div>
    )
}

export default CartPage
