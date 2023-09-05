import './App.css';
import AddUser from './Component/AddUser';
import GetUser from './Component/GetUser';
import PutUser from './Component/PutUser';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
function App() {
  return (
    <div className="App">
    <BrowserRouter>
    <Routes>
      <Route index element={<GetUser/>}/>
      <Route path='/add' element={<AddUser/>}/>
      <Route path='/put/:id' element={<PutUser/>}/>
    </Routes>
    </BrowserRouter>
    
   </div>
  );
}

export default App;
