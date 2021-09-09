import {userContext, createContext, useContext} from "react"

//session state management

export const AppContext = createContext(null);

export function useAppContext() {
    return useContext(AppContext);
}