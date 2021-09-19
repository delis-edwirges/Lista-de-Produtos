import { Categoria } from "./Categoria"
import { Usuario } from "./Usuario"

export class Produto {

    
    public id: number
    public nomeProduto: string
    public descricao: string
    public preco: number
	public tipoUsuario:string 
	public disponivel: boolean 
    public data: Date 
    public usuario: Usuario
    public categoria: Categoria
	
}