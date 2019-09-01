// Angular
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


// UI
import {
  AccordionModule,
  GMapModule,
  ButtonModule,
  CalendarModule,
  CheckboxModule,
  CodeHighlighterModule,
  ConfirmDialogModule,
  DataTableModule,
  DialogModule,
  FileUploadModule,
  GrowlModule,
  InputTextModule,
  ListboxModule,
  MultiSelectModule,
  PanelModule,
  RadioButtonModule,
  SharedModule,
  TabViewModule,
  ChartModule,
  TooltipModule,
  ConfirmDialog,
  BlockableUI,
  BlockUI,
  BlockUIModule
} from 'primeng/primeng';
import { MessageService } from 'primeng/components/common/messageservice';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


// Modules
import { NgPipesModule } from 'ng-pipes';

// Components
import { AppComponent } from './app.component';
import {
  HomeComponent,
  LoginComponent,
  TableViewComponent,
  EntryDetailsComponent,
  ProfileComponent,
  RegisterComponent,
  SentimentAnalysisComponent,
  MasterComponent
} from 'app/components';

// Services
import {
  ApiService,
  AuthenticationService,
  AuthGuard,
  LocalStorageService,
  SocketService
} from 'app/service';

import { AppRoutingModule } from './app-routing.module';
import { SocketIoModule, SocketIoConfig } from 'ng-socket-io';
import { InstagramComponent } from './components/pages/instagram/instagram.component';

const config: SocketIoConfig = { url: 'http://localhost:4000', options: {} };


@NgModule({
  declarations: [
    AppComponent,
    EntryDetailsComponent,
    HomeComponent,
    LoginComponent,
    ProfileComponent,
    RegisterComponent,
    MasterComponent,
    TableViewComponent,
    SentimentAnalysisComponent,
    InstagramComponent,
  ],
  imports: [
    AccordionModule,
    SocketIoModule.forRoot(config),
    AppRoutingModule,
    BlockUIModule,
    BrowserAnimationsModule,
    BrowserModule,
    ButtonModule,
    CalendarModule,
    CheckboxModule,
    CodeHighlighterModule,
    ConfirmDialogModule,
    DataTableModule,
    DialogModule,
    FileUploadModule,
    FormsModule,
    FormsModule,
    GrowlModule,
    ChartModule,
    HttpModule,
    InputTextModule,
    ListboxModule,
    GMapModule,
    MultiSelectModule,
    NgPipesModule,
    PanelModule,
    RadioButtonModule,
    ReactiveFormsModule,
    SharedModule,
    TabViewModule,
    TooltipModule,
  ],
  providers: [
    ApiService,
    AuthenticationService,
    AuthGuard,
    LocalStorageService,
    MessageService,
    SocketService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
