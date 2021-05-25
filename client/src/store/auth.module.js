import ApiService from "@/common/api.service";
import JwtService from "@/common/jwt.service";
import {CHECK_AUTH, LOGIN, LOGOUT, REGISTER, UPDATE_USER} from "./actions.type";
import {PURGE_AUTH, SET_AUTH, SET_ERROR} from "./mutations.type";

const state = {
    errors: null,
    user: {},
    isAuthenticated: !!JwtService.getToken()
};

const getters = {
    currentUser(state) {
        return state.user;
    },
    isAuthenticated(state) {
        return state.isAuthenticated;
    }
};

const actions = {
    [LOGIN](context, credentials) {
        return new Promise(resolve => {
            ApiService.post("user/login", credentials)
                .then((res) => {
                    console.log("data", res);
                    context.commit(SET_AUTH, res.data.accessToken);
                    resolve(res);
                })
                .catch((res) => {
                    console.log("response", res);
                    context.commit(SET_ERROR, res.data.errors);
                });
        });
    },
    [LOGOUT](context) {
        context.commit(PURGE_AUTH);
    },
    [REGISTER](context, credentials) {
        return new Promise((resolve, reject) => {
            ApiService.post("users", {user: credentials})
                .then(({data}) => {
                    context.commit(SET_AUTH, data.user);
                    resolve(data);
                })
                .catch(({response}) => {
                    context.commit(SET_ERROR, response.data.errors);
                    reject(response);
                });
        });
    },
    [CHECK_AUTH](context) {
        if (JwtService.getToken()) {
            ApiService.setHeader();
            ApiService.get("user")
                .then(({data}) => {
                    context.commit(SET_AUTH, data.user);
                })
                .catch(({response}) => {
                    context.commit(SET_ERROR, response);
                    // context.commit(SET_ERROR, response.data.errors);
                });
        } else {
            context.commit(PURGE_AUTH);
        }
    },
    [UPDATE_USER](context, payload) {
        const {email, username, password, image, bio} = payload;
        const user = {
            email,
            username,
            bio,
            image
        };
        if (password) {
            user.password = password;
        }

        return ApiService.put("user", user).then(({data}) => {
            context.commit(SET_AUTH, data.user);
            return data;
        });
    }
};

const mutations = {
    [SET_ERROR](state, error) {
        state.errors = error;
    },
    [SET_AUTH](state, accessToken) {
        console.log("set auth", accessToken)
        state.isAuthenticated = true;
        state.accessToken = accessToken;
        state.errors = {};
        JwtService.saveToken(state.accessToken);
    },
    [PURGE_AUTH](state) {
        state.isAuthenticated = false;
        state.user = {};
        state.errors = {};
        JwtService.destroyToken();
    }
};

export default {
    state,
    actions,
    mutations,
    getters
};
