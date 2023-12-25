<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
/* Google Font Link */
* {
    box-sizing: border-box;
}

body {
    background: #1a1a1a;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    font-family: 'Montserrat', sans-serif;
    height: 100vh;
    margin: -20px 0 50px;
    margin-right: 220px;
}

h1 {
    font-weight: bold;
    margin: 0;
    color: #ffffff; /* Couleur du texte */
}

h2 {
    text-align: center;
    color: #cccccc; /* Couleur du texte */
}

p {
    font-size: 14px;
    font-weight: 100;
    line-height: 20px;
    letter-spacing: 0.5px;
    margin: 20px 0 30px;
    color: #999999; /* Couleur du texte */
}

span {
    font-size: 12px;
    color: #666666; /* Couleur du texte */
}

a {
    color: #ffcc00; /* Couleur du lien */
    font-size: 14px;
    text-decoration: none;
    margin: 15px 0;
}

button {
    border-radius: 20px;
    border: 1px solid #ff3399; /* Couleur de la bordure */
    background-color: #ff3399; /* Couleur de fond */
    color: #FFFFFF;
    font-size: 12px;
    font-weight: bold;
    padding: 12px 45px;
    letter-spacing: 1px;
    text-transform: uppercase;
    transition: transform 80ms ease-in;
}

button:active {
    transform: scale(0.95);
}

button:focus {
    outline: none;
}

button.ghost {
    background-color: transparent;
    border-color: #FFFFFF;
}

form {
    background-color: #FFFFFF;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    padding: 0 50px;
    height: 100%;
    text-align: center;
}

input {
    background-color: #eee;
    border: none;
    padding: 12px 15px;
    margin: 8px 0;
    width: 100%;
}

.container {
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25),
                0 10px 10px rgba(0, 0, 0, 0.22);
    position: relative;
    overflow: hidden;
    width: 768px;
    max-width: 100%;
    min-height: 480px;
    margin-left: 250px;
    margin-top: 50px;
}

.form-container {
    position: absolute;
    top: 0;
    height: 100%;
    transition: all 0.6s ease-in-out;
}

.sign-in-container {
    left: 0;
    width: 50%;
    z-index: 2;
}

.container.right-panel-active .sign-in-container {
    transform: translateX(100%);
}

.sign-up-container {
    left: 0;
    width: 50%;
    opacity: 0;
    z-index: 1;
}

.container.right-panel-active .sign-up-container {
    transform: translateX(100%);
    opacity: 1;
    z-index: 5;
    animation: show 0.6s;
}

@keyframes show {
    0%, 49.99% {
        opacity: 0;
        z-index: 1;
    }

    50%, 100% {
        opacity: 1;
        z-index: 5;
    }
}

.overlay-container {
    position: absolute;
    top: 0;
    left: 50%;
    width: 50%;
    height: 100%;
    overflow: hidden;
    transition: transform 0.6s ease-in-out;
    z-index: 100;
}

.container.right-panel-active .overlay-container {
    transform: translateX(-100%);
}

.overlay {
    background: #9933cc; /* Couleur de fond */
    background: -webkit-linear-gradient(to right, #ff3399, #9933cc); /* Dégradé */
    background: linear-gradient(to right, #ff3399, #9933cc); /* Dégradé */
    background-repeat: no-repeat;
    background-size: cover;
    background-position: 0 0;
    color: #FFFFFF;
    position: relative;
    left: -100%;
    height: 100%;
    width: 200%;
    transform: translateX(0);
    transition: transform 0.6s ease-in-out;
}

.container.right-panel-active .overlay {
    transform: translateX(50%);
}

.overlay-panel {
    position: absolute;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    padding: 0 40px;
    text-align: center;
    top: 0;
    height: 100%;
    width: 50%;
    transform: translateX(0);
    transition: transform 0.6s ease-in-out;
}

.overlay-left {
    transform: translateX(-20%);
}

.container.right-panel-active .overlay-left {
    transform: translateX(0);
}

.overlay-right {
    right: 0;
    transform: translateX(0);
}

.container.right-panel-active .overlay-right {
    transform: translateX(20%);
}

.social-container {
    margin: 20px 0;
}

.social-container a {
    border: 1px solid #DDDDDD;
    border-radius: 50%;
    display: inline-flex;
    justify-content: center;
    align-items: center;
    margin: 0 5px;
    height: 40px;
    width: 40px;
    color: #FFFFFF; /* Couleur de l'icône */
}

.social-container a:hover {
    background-color: rgb(107, 97, 97);
}

    	
    	</style>
    
</head>
<body>

<div class="container" id="container" <%-- Add your Angular bindings here if necessary --%>>
    <div class="form-container sign-up-container">
        <form action="/application/signup" method="post">
            <h1>Create Account</h1>
            
            <input type="username" placeholder="Name" name="username" required/>
            <input type="email" placeholder="Email" name="email" required/>
            <input type="password" placeholder="Password" name="password" required/>
            <button type="submit">Sign Up</button>
            
        </form>

    </div>
    <div class="form-container sign-in-container">
        <form action="/application/" method="post">
            <h1>Sign in</h1>
            
            <input type="email" placeholder="Email" name="email" required/>
            <input type="password" placeholder="Password" name="password" required/>
            <a href="#">Forgot your password?</a>
            <button type="submit">Sign In</button>
	        <c:if test="${not empty errorMessage}">
	    	<p style="color: red;">${errorMessage}</p>
			</c:if>
        </form>
        
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back!</h1>
                <p>To keep connected with us, please login with your personal info</p>
                <button class="ghost" id="signIn" onclick="onSignInClick()">Sign In</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hello, Friend!</h1>
                <p>Enter your personal details and start your journey with us</p>
                <button class="ghost" id="signUp" onclick="onSignUpClick()">Sign Up</button>
            </div>
        </div>
    </div>
</div>

<script>
    function onSignInClick() {
        // Hide the Sign Up form and show the Sign In form
        document.getElementById('container').classList.remove('right-panel-active');
    }

    function onSignUpClick() {
        // Hide the Sign In form and show the Sign Up form
        document.getElementById('container').classList.add('right-panel-active');
    }
    
</script>


</body>
</html>
