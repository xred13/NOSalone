export const setLoggedInAction = (status) => {
    return{
        type: "SET_LOGGED_IN",
        isLoggedIn: status
    }
}