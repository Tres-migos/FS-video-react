import { useState } from "react";


export default () => {
    const [form, setForm]=useState();


    const onChange = (e, {name, value}) => {
        setForm({...form, [name]: value});

    };

       console.log('form', form);
    return {form, onChange};
};