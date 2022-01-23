<!DOCTYPE html>
<html>
    <head>
        <title>Shopping Cart UI</title>
        <link rel="stylesheet" type="text/css" href="./css/style.css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,900" rel="stylesheet">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        
    </head>
    <body>
        <div class="CartContainer">
            <div class="Header">
                <h3 class="Heading">Your Cart. Please place order. </h3>
                <h5 class="Action">Remove all</h5>
            </div>

            <div class="Cart-Items">
                <div class="image-box">
                    <img src="images/apple.png" style="height:120px" />
                </div>
                <div class="about">
                    <h1 class="title">Apple Juice</h1>
                    <h3 class="subtitle">250ml</h3>
                    <img src="images/veg.png" style="height:30px"/>
                </div>
                <div class="counter">
                    <div class="btn">+</div>
                    <div class="count">2</div>
                    <div class="btn">-</div>
                </div>
                <div class="prices">
                    <div class="amount"><i class="fa fa-inr"></i>2.99</div>
                    <div class="remove"><u>Remove</u></div>
                </div>
            </div>
            <hr> 
            <div class="checkout">
                <div class="total">
                    <div>
                        <div class="Subtotal">Sub-Total</div>
                        <div class="items">2 items</div>
                    </div>
                    <div class="total-amount"><i class="fa fa-inr"></i>6.18</div>
                </div>
                <button class="button">Checkout</button></div>
        </div>
    </body>
</html>