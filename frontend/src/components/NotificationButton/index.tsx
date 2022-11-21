import axios from 'axios';
import { toast } from 'react-toastify';
import icon from '../../assets/img/notification-icon.svg'
import { BASE_URL } from '../../utils/request';
import './styles.css'

type Props = {
    saleId: number;
}

{/*esta funçao a baixo e responsavel por chamar minha api no backend*/}
function handleClick(id : number){
    axios(`${BASE_URL}/sales/${id}/notification`).then(response => {
        toast.info("SMS enviado com Sucesso");
    }); {/*axios responsavel por fazer a requisiçao */}
}

{/*passei por paramentro o id com saleId e depois dois pontos disse qual tipo q é no caso Props(props é um argumento aqui no javaScript) */}
function NotificationButton( {saleId} : Props) { 
    return(

        <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
            <img src={icon} alt="Notificar"></img>
        </div>
    )
  }
  
  export default NotificationButton
  