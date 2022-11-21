import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import NotificationButton from "./components/NotificationButton"
import Header from "./components/Header"
import SalesCard from "./components/SalesCard"

function App() {
  return(
   <>
   
   <ToastContainer/>  {/* componente do react-toastify importao a cima. apartir desta declaraçao posso invocar uma mss em qualquer componente */}
    <Header/>
    <main>
        <section id="sales">
            <div className ="dsmeta-container"> 
              <SalesCard/>
            </div>
        </section>
    </main>    
   </>
  )
}

export default App
