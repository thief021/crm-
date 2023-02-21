function loginApi(data) {
  return $axios({
    'url': '/api/user/login',
    'method': 'post',
    data
  })
}

function logoutApi(){
  return $axios({
    'url': '/api/user/logout',
    'method': 'post',
  })
}
