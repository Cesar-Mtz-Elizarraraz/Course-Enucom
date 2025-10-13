import { ZodSchema } from "zod";

export interface FormValidation{
    id: string;
    isValid: boolean;
    schema: ZodSchema<any>
}