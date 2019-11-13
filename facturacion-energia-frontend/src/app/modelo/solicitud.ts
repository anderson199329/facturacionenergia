import { SolicitudData } from "./solicitudData";
import { InformacionServicio } from "./informacionServicio";

export class Solicitud{

    solicitudData:SolicitudData;
    informacionServicio:InformacionServicio;

    constructor(solicitudData:SolicitudData, informacionServicio:InformacionServicio){

        this.solicitudData = solicitudData;
        this.informacionServicio = informacionServicio;

    }

}