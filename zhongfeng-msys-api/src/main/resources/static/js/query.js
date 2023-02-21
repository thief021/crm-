// 查询列表接口
const queryAllCircuits = (params) => {
    return $axios({
        url: '/api/circuit/queryAllCircuits',
        method: 'post',
        data: {...params}
    })
}

const queryAllIp = (params) => {
    return $axios({
        url: '/api/end/queryAllIp',
        method: 'post',
        data: {...params}
    })
}

const queryAllCustomer = (params) => {
    return $axios({
        url: '/api/customer/queryAllCustomer',
        method: 'post',
        data: {...params}
    })
}

const queryCircuitProperty = (params) => {
    return $axios({
        url: '/api/circuit/queryCircuitProperty',
        method: 'post',
        data: {...params}
    })
}

// 删除当钱线路
const deleteCircuitProperty = (params) => {
    return $axios({
        url: '/api/circuit/deleteCircuitProperty',
        method: 'post',
        data: {...params}
    })
}

const deleteCustomer = (params) => {
    return $axios({
        url: '/api/customer/deleteCustomer',
        method: 'post',
        data: {...params}
    })
}

const deleteIp = (params) => {
    return $axios({
        url: '/api/end/deleteIp',
        method: 'post',
        data: {...params}
    })
}

// 删除当前下游
const deleteEnd = (params) => {
    return $axios({
        url: '/api/end/deleteEnd',
        method: 'post',
        data: {...params}
    })
}

const deleteFront = (params) => {
    return $axios({
        url: '/api/front/deleteFront',
        method: 'post',
        data: {...params}
    })
}

const deleteUser = (params) => {
    return $axios({
        url: '/api/user/deleteUser',
        method: 'post',
        data: {...params}
    })
}

const queryAllEnd = (params) => {
    return $axios({
        url: '/api/end/queryAllEnd',
        method: 'post',
        data: {...params}
    })
}

const queryAllUser = (params) => {
    return $axios({
        url: '/api/user/queryAllUser',
        method: 'post',
        data: {...params}
    })
}

const queryAllFront = (params) => {
    return $axios({
        url: '/api/front/queryAllFront',
        method: 'post',
        data: {...params}
    })
}

// 修改线路
const updateCircuitProperty = (params) => {
    return $axios({
        url: '/api/circuit/updateCircuitProperty',
        method: 'post',
        data: {...params}
    })
}

const updateIp = (params) => {
    return $axios({
        url: '/api/end/updateIp',
        method: 'post',
        data: {...params}
    })
}

const updateCustomer = (params) => {
    return $axios({
        url: '/api/customer/updateCustomer',
        method: 'post',
        data: {...params}
    })
}

// 修改下游
const updateEnd = (params) => {
    return $axios({
        url: '/api/end/updateEnd',
        method: 'post',
        data: {...params}
    })
}

const updateFront = (params) => {
    return $axios({
        url: '/api/front/updateFront',
        method: 'post',
        data: {...params}
    })
}

const updateUser = (params) => {
    return $axios({
        url: '/api/user/updateUser',
        method: 'post',
        data: {...params}
    })
}

const addCircuitProperty = (params) => {
    return $axios({
        url: '/api/circuit/addCircuitProperty',
        method: 'post',
        data: {...params}
    })
}

const addCustomer = (params) => {
    return $axios({
        url: '/api/customer/addCustomer',
        method: 'post',
        data: {...params}
    })
}

const addIp = (params) => {
    return $axios({
        url: '/api/end/addIp',
        method: 'post',
        data: {...params}
    })
}

// 新增下游
const addEnd = (params) => {
    return $axios({
        url: '/api/end/addEnd',
        method: 'post',
        data: {...params}
    })
}

const addFront = (params) => {
    return $axios({
        url: '/api/front/addFront',
        method: 'post',
        data: {...params}
    })
}

const addUser = (params) => {
    return $axios({
        url: '/api/user/addUser',
        method: 'post',
        data: {...params}
    })
}