import React from "react";

export default function Login() {
    return (
        <div>
            <p>This is the login page.</p>
            <a href="http://localhost:8080/login?redirect_url=http://localhost:3000/user">
                Sign in with Google
            </a>
        </div>
    );
}
