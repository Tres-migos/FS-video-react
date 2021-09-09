import { useEffect } from "react"
import Register from "../../Pages/Register"
import useForm from "./useForm";

const RegisterContainer = () => {
    useEffect(()=> {
        register();
    }, []);

    return <Register form={useForm()}/>;
};

export default RegisterContainer;