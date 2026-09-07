import React from 'react'
import axios from 'axios'


const ProductCard = (props) => {


    const addToCart = async () => {
        const cartData = {
            product: {
                productId: props.elem.productId
            },
            quantity: 1
        }

        const response=await axios.post(`http://localhost:8080/api/cart/create`,cartData)

        console.log(response.data);

        // console.log("Hello")
        
    }
    // console.log(props)
    return (
        <div className='bg-pink-200 w-80 flex flex-col p-3 rounded '>
            <div className='p-2 bg-white w-full h-70'>
                <img className='w-full h-full object-cover' src={`/images/${props.elem.image}`} alt="" />

            </div>
            <h2 className='mt-3'>{props.elem.productName}</h2>

            <div className='flex justify-between '>

                <p>₹ {props.elem.price}</p>

                <button onClick={addToCart} className='bg-red-400 rounded p-2 text-white'>Add To Cart</button>
            </div>


        </div>
    )
}

export default ProductCard
