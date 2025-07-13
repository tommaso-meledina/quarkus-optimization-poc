/* tslint:disable */
/* eslint-disable */

export interface BaseDto {
}

export interface BaseResponse extends BaseDto {
    message?: string;
}

export interface BaseUuidDto extends BaseDto {
    uuid: string;
}

export interface Dummy extends BaseUuidDto {
    name: string;
}

export interface GetDummyResponse extends BaseResponse {
    dummies?: Dummy[];
}

export interface GetOptionsResponse extends BaseResponse {
    options?: KeyValueItem[];
}

export interface KeyValueItem extends BaseUuidDto {
    key: string;
    value?: string;
}

export interface PostDummyRequest {
    dummyName?: string;
}

export interface PostDummyResponse extends BaseResponse {
    insertedRecords?: number;
}

export interface PutDummyRequest {
    dummy?: Dummy;
}

export interface PutDummyResponse extends BaseResponse {
    updatedRecord?: Dummy;
}
