
import axios from "axios";
import { useEffect, useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { Sale } from "../../models/sale";
import { BASE_URL } from "../../utils/request";
import NotificationButton from '../NotificationButton'
import  './styles.css'

function SalesCard() {
    const min = new Date(new Date().setDate(new Date().getDate() - 365));
    const max = new Date(); {/* data atual */} 
    const [minDate , setMinDate] = useState(min);
    const [maxDate,  setMaxDate] = useState(max);

/*a linhas a seguir pega os valores que virao do backend atraves do arquivo definido components/models/sales.ts*/
    const [sales, setSales] = useState<Sale[]> ([]);   


/* esta linnha a baixo veio do import useEfect from react. ela faz a busca no backend 
o $BASE_URL é a variavel defina em no arquivo request.ts q esta dentro de utils q esta dentro de src*/
    useEffect(()=>{

/* estou pegando a data convertendo ela para ano mes e dia para jogar na requisiçao http. posso ular o console.log() para verificar como vai sair */
        const dmin = minDate.toISOString().slice(0,10); // slice recorta o texto neste caso desde a posiçao 0 e pega 10 caracteres para frente
        const dmax = maxDate.toISOString().slice(0,10);

        axios.get(`${BASE_URL}/sales?minDate=${dmin}&maxDate=${dmax}`).then(response => {
            setSales(response.data.content);
        });
     }, [minDate, maxDate]);


    return(
   
        <div className="dsmeta-card">
            <h2 className="dsmeta-sales-title">Vendas</h2>

            <div className="container">
               <div className="dsmeta-form-control-container">
                 <DatePicker
                    selected={minDate}
                    onChange={(date: Date) => setMinDate(date)}
                    className="dsmeta-form-control"
                    dateFormat="dd/MM/yyyy"
                />
               </div>

               <div className="dsmeta-form-control-container">
                <DatePicker
                    selected={maxDate}
                    onChange={(date: Date) => setMaxDate(date)}
                    className="dsmeta-form-control"
                    dateFormat="dd/MM/yyyy"
                />
               </div>
            </div>

            <div>
                 <table className="dsmeta-sales-table"> 
                     <thead> 
                         <tr>
                             <th className="show992">ID</th>
                             <th className="show576">Data</th> 
                             <th >Vendedor</th>
                             <th className="show992">Visitas</th>
                             <th className="show992">Vendas</th>
                             <th>Total</th>
                             <th>Notificar</th>
                         </tr>
                     </thead>
                     <tbody>
                        {/* linhas a seguir faz os dados dinâmicos...este map permite percorrer uma lista e fazer uma operaçao a cada iten da list */}
                        {/*sales é um apelido para cada item d lista => aponta para funçao a segui das chaves q será executada para cada item */}
                        
                        {sales.map(sale =>{
                            return(
                                <tr key={sale.id}> {/*sempre q usar uma renderizaçao de conteudo desta forma o react exige q eu uso o key com um indetificador unico, entao usei o proprio id*/}
                             <td className="show992">{sale.id}</td>
                             <td className="show576">{new Date(sale.date).toLocaleDateString()}</td> {/*funçao java script para formatar datas*/}
                             <td>{sale.sellerName}</td> 
                             <td className="show992">{sale.visited}</td>
                             <td className="show992">{sale.deals}</td>
                             <td>R$ {sale.amount.toFixed(2)}</td> {/*.tofixed funçao javascript para formatar com duas casas decimais*/}
                             <td>
                                 <div className="dsmeta-red-btn-container">
                                    <NotificationButton/>
                                 </div>
                                 
                             </td>
                         </tr>
                            )
                        })

                        }
                        
                     </tbody>
                 </table>
            </div>
         </div>
      
    )
  }
  
  export default SalesCard
   
 
 
 
 
 
 
 
 