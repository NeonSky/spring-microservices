import React, { useState, useEffect } from "react";
import axios from "axios";

export default function User() {
    const [data, setData] = useState({
        fullName: "",
        email: "",
    });

    useEffect(() => {
        const transport = axios.create({withCredentials: true});
        transport.get('http://localhost:8080/user')
            .then(function(response) {
                setData(response.data);
            })
    }, []);

    return (
        <div>
            <p>This is you, the logged in user.</p>
            {data.fullName}
            <br/>
            {data.email}
        </div>
    );
}
