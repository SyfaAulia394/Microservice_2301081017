# Pasien API

## Create pasien
Endpoint : POST /api/pasien

request body: 
```json
{
    "nama" :"pasien a",
    "jeniskelamin" : "perempuan",
    "tanggalLahir":"22 november 2004",
    "nohp":"080976532809",
    "alamat":"padang"

}
```

response body (success):
```json
{
    "msg" :"pasien berhasil ditambahkan",
}
```

response body (failed):
```json
{
    "msg" :"pasien gagal ditambahkan",
}
```