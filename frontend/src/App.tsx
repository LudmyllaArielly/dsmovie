/* Componentes importados servem para configurar a rota */
import {
  BrowserRouter, /* aqui deixei a nav que deve ser mostrada em todas as paginas  */
  Routes, /* vai configurar rota por rota */
  Route
} from "react-router-dom";

/* impotandando componentes criados para ativar a rota neles */
import Listing from 'pages/Listing';
import Form from 'pages/Form';
import Navbar from "components/Navbar";

function App() {
  return (
    <BrowserRouter> 
      <Navbar /> 
      <Routes>
        <Route path="/" element={<Listing />} />
        <Route path="/form">
          <Route path=":movieId" element={<Form />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;