import axios from 'axios';

const axiosClient = axios.create({
    baseURL: 'http://localhost:8081',
    headers: {"Access-Control-Allow-Origin": "*"}
});

export default axiosClient;