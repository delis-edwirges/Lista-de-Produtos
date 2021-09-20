import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { OrderModule } from 'ngx-order-pipe';
import { ModalModule } from 'ngx-bootstrap/modal';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EntrarComponent } from './entrar/entrar.component';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { HomeComponent } from './home/home.component';
import { AlertasComponent } from './alertas/alertas.component';
import { ProdutoEditComponent } from './edit/produto-edit/produto-edit.component';
import { CategoriaEditComponent } from './edit/categoria-edit/categoria-edit.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';
import { CategoriasComponent } from './categorias/categorias.component';
import { CategoriaDeleteComponent } from './delete/categoria-delete/categoria-delete.component';
import { ProdutoDeleteComponent } from './delete/produto-delete/produto-delete.component';
import { ProdutoComponent } from './produto/produto.component';
import { UsuarioEditComponent } from './edit/usuario-edit/usuario-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    EntrarComponent,
    CadastrarComponent,
    HomeComponent,
    AlertasComponent,
    ProdutoEditComponent,
    CategoriaEditComponent,
    MenuComponent,
    FooterComponent,
    CategoriasComponent,
    CategoriaDeleteComponent,
    ProdutoDeleteComponent,
    ProdutoComponent,
    UsuarioEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ModalModule.forRoot(),
    OrderModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
