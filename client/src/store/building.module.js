import ApiService from "@/common/api.service";
import JwtService from "@/common/jwt.service";
import {ADD_BUILDING, GET_ALL_BUILDING} from "./actions.type";
import {SET_ERROR} from "./mutations.type";
import {REMOVE_BUILDING} from "@/store/actions.type";

const state = {
    errors: null,
    user: {},
    isAuthenticated: !!JwtService.getToken()
};

const getters = {};

const actions = {
    [ADD_BUILDING](context, building) {
        return new Promise(resolve => {
            ApiService.post("building", building)
                .then((res) => {
                    resolve(res);
                })
                .catch((res) => {
                    context.commit(SET_ERROR, res.data.errors);
                });
        });
    },
    [GET_ALL_BUILDING](context) {
        return new Promise(resolve => {
            ApiService.get("/building")
                .then((res) => {
                    resolve(res.data);
                })
                .catch((res) => {
                    context.commit(SET_ERROR, res.data.errors);
                });
        });
    },
    [REMOVE_BUILDING](context, data) {
        console.log("data", data)
        return new Promise(resolve => {
            ApiService.delete("/building", data)
                .then((res) => {
                    resolve(res);
                })
                .catch((res) => {
                    context.commit(SET_ERROR, res.data.errors);
                });
        });
    }
};

const mutations = {};

export default {
    state,
    actions,
    mutations,
    getters
};
