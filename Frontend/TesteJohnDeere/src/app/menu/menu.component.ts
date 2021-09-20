import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Categoria } from '../model/Categoria';
import { Produto } from '../model/Produto';
import { Usuario } from '../model/Usuario';
import { AlertasService } from '../service/alertas.service';
import { AuthService } from '../service/auth.service';
import { CategoriaService } from '../service/categoria.service';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {


  nomeusuario = environment.nomeUsuario
  idUsuario = environment.id
  foto = environment.foto
  id = environment.id
  tipo = environment.tipoUsuario

  
  produto: Produto = new Produto()
  listaProduto:Produto[]
  prod2: Produto = new Produto()
  nomeProduto: string


  key = 'data'
  reverse = true

  idPost: number
  idProduto:number
  
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private categoriaService: CategoriaService,
    private produtoService: ProdutoService,
    public authService: AuthService,
    private alertas: AlertasService
  ) { }

  ngOnInit() {

  }


  sair() {
    this.router.navigate(['/entrar'])
    environment.token ='',
    environment.nomeUsuario ='',
    environment.foto ='',
    environment.id =0
  }

  getAllProduto(){
    this.produtoService.getAllProduto().subscribe((resp: Produto[])=>{
      this.listaProduto = resp
    })
  }

  findByIdProduto(){
    this.produtoService.getByIdProduto(this.idProduto).subscribe((resp: Produto)=>{
      this.prod2 = resp
      })
    }


  findByNomeProduto(){
    if(this.nomeProduto == ''){
      this.getAllProduto()
    } else {

      this.produtoService.getByNomeProduto(this.nomeProduto).subscribe((resp : Produto[])=> {
        this.listaProduto = resp
      })
    };
  }


}