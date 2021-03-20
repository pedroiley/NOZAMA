<html>
<head>
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <h1 align="center"> NOZAMA - BUY EVERYTHING YOU NEED</h1>
     <h1 align="center"> PLEASE REGISTER BELOW</h1>

     <div align="center">
        <h1 align="center"> Welcome! Please add your contact below: </h1>
                <form border="2px" action="/user" method="POST">
                    <input type="text" name="username" placeholder="Enter your username"/>
                    <br>
                    <input type="text" name="password" placeholder="Enter your password"/>
                    <br>
                    <input type="text" name="email" placeholder="Enter your email"/>
                    <br>
                    <input type="submit" value="ADD USER"/>
                </form>
            </div>

    <div align="center">
        User Username is : ${username}
        <br>
        User Lastname is : ${password}
        <br>
        User Email is : ${email}
    </div>
    <h1 align="center"> Wohoo! It worked out!</h1>
</body>
</html>