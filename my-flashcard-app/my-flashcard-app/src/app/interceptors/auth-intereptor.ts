import { HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest, HttpResponse, HttpXsrfTokenExtractor } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { flashcardServiceHostname, flashcardServicePort, hostname, port } from "../enums/app";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  private readonly httpResp: HttpResponse<any>;

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // let csrfToken = this.tokenExtractor.getToken();
    const secureRequest = req.clone({
      // headers: req.headers.set(
      //   'X-XSRF-TOKEN',
      //   csrfToken
      // ),
      // withCredentials: true,
      url: req.url.replace('http://', `http://${flashcardServiceHostname}:${flashcardServicePort}/`)
    });
    return next.handle(secureRequest);
  }

  constructor(
    private tokenExtractor: HttpXsrfTokenExtractor
  ) {}
}