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
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  produto: Produto = new Produto()
  listaProduto:Produto[]
  nomeProduto: string

  categoria: Categoria = new Categoria
  listaCategoria: Categoria[]
  idCategoria: number

  usuario: Usuario = new Usuario
  idUsuario = environment.id
  prod2: Produto = new Produto()
  foto = environment.foto
  nome = environment.nomeUsuario


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
    window.scroll(0,0)
    if (environment.token == ''){
      this.alertas.showAlertInfo('Sua sessão expirou, faça o login novamente!')
      this.router.navigate(['/entrar'])
    }
      this.getAllProduto()
      this.getAllCategoria()

          
    }



    getAllCategoria(){
      this.categoriaService.getAllCategoria().subscribe((resp: Categoria[])=>{
        this.listaCategoria = resp
      })
    }


    findByIdCategoria(){
    this.categoriaService.getByIdCategoria(this.idCategoria).subscribe((resp: Categoria)=>{
      this.categoria = resp
      })
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


  findByIdUsuario(){
    this.authService.getByIdUsuario(this.idUsuario).subscribe((resp:Usuario)=>{
      this.usuario = resp
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

  publicar(){
    this.categoria.id = this.idCategoria
    this.produto.categoria = this.categoria

    this.usuario.id = this.idUsuario
    this.produto.usuario = this.usuario
     console.log(this.produto)
     console.log(environment)
    this.produtoService.postProduto(this.produto).subscribe((resp: Produto) =>{
      this.produto = resp
      this.alertas.showAlertSuccess('Produto postada com sucesso!')
      this.produto = new Produto()
      this.getAllProduto()
    })
  }

  apagar(){

    this.produtoService.deleteProduto(this.idPost).subscribe(()=>{
      alert('A postagem selecionado foi apagada.')
      this.router.navigate(['/home'])
    })

}

}

