export class CuentaBanc{

    constructor(private id: Number,
        private iban: String,
        private dni: String)
        {

        }
        public toString(): String{
            return `Cuenta: ${this.id}
                IBAN: ${this.iban}
                DNI: ${this.dni}`;
        }
}