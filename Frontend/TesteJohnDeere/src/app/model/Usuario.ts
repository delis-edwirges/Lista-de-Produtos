import { Produto } from "./Produto"

export class Usuario{

    public id: number
    public nomeUsuario: string
    public dataNascimento: Date
    public senha: string
    public email: string
	public tipoUsuario:string 
	public foto: string 
    public produto: Produto[]
	
	

}