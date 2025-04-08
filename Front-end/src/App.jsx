import axios from "axios";
import './App.css'

function App() {
  axios.get("/api/v1/userinfo")
  .then(response => {
    console.log(response.data);
  })
  .catch(error => {
    console.error(error);
  });
  return (
    <>
  
    </>
  )
}

export default App
