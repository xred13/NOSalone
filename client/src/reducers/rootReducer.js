const initState = {
    isLoggedIn: false
}

const rootReducer = (state = initState, action) => {
    if(action.type === "SET_LOGGED_IN"){
        return {
            ...state,
            isLoggedIn: action.isLoggedIn
        }
    }
    return state;
}

export default rootReducer;