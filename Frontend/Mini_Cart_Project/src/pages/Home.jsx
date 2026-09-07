import React, { useEffect, useState } from 'react'
import axios from 'axios'

import ProductCard from '../components/ProductCard'

const Home = () => {

    const [productData, SetProductData] = useState([])

    const GetData = async () => {


        const response = await axios.get(`http://localhost:8080/api/product`)
        console.log(response);
        SetProductData(response.data)



    }

    useEffect(function () {
        GetData()
    }, [])
    return (
        <div>
            <div className='flex justify-center py-6'>
                <h1>Our Products</h1>

            </div>

            <div className='flex flex-wrap gap-20'>


                {
                    productData.map(function (elem) {
                        return <div key={elem.productId} className='flex gap-2'>
                            <ProductCard elem={elem} />

                        </div>
                    })

                }
            </div>

        </div>
    )
}

export default Home
