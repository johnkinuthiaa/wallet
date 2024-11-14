export const Hero= (()=>{
    return(
        <div className={"Hero flex m-20"}>
            <div>
                <h1 className={"font-bold text-5xl mt-40 mr-40 w-2/4 ml-40"}>Take Control of your <span className={"text-blue-600"}>mobile wallet</span>
                </h1>
                <p className={"w-2/4 mt-5 ml-40"}>Safeguard Your Digital Assets with Our Secure Crypto Wallet. Store, manage, and transact with confidence using our advanced features and intuitive interface. </p>
                <button className={"w-1/4 mt-5 ml-40 bg-blue-500 text-white p-4"}>Get Started</button>
            </div>
            <img src={"https://framerusercontent.com/images/a8Kpg4KoZH6RBXA6VJuBvsmR7I.svg"} alt={"mobile-img"}
                 className={"mr-40 w-80 bg-gradient-to-b"}></img>
        </div>

    )
})