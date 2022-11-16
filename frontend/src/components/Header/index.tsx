import logo from  "../../assets/img/logo.svg"
import './styles.css'
function Header() {
  return(
 
    <header>
        <div className="dsmeta-logo-container">
             <img src={logo} alt="DSMeta"></img>
            <h1>DSMeta</h1>
            <p>
                Desenvovido por <a href="">hosias.souza@gmail.com</a> <a href="https://api.whatsapp.com/send?phone=5561991906140">(61)991906140</a>
            </p>
        </div>
</header>
    
  )
}

export default Header
