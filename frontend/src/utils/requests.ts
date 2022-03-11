/*
Caso minha variavel no netlify nao esteja definida,
 vai usar por padrao o localhost
 */
export const BASE_URL = process.env.REACT_APP_BACKEND_URL ??  "http://localhost:8080";