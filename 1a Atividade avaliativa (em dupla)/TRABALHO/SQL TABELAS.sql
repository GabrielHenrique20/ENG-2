CREATE TABLE [paciente775799] (
	[CPF] int IDENTITY(1,1) NOT NULL UNIQUE,
	[Nome] nvarchar(100) NOT NULL,
	[Endereco] nvarchar(150) NOT NULL,
	[Telefone] nvarchar(15) NOT NULL,
	[DataNascimento] date NOT NULL,
	[Quarto] int NOT NULL,
	PRIMARY KEY ([CPF])
);

CREATE TABLE [medico775799] (
	[CRM] int IDENTITY(1,1) NOT NULL UNIQUE,
	[Nome] nvarchar(100) NOT NULL,
	[Salario] float(100000) NOT NULL,
	[Especialidade] nvarchar(50) NOT NULL,
	PRIMARY KEY ([CRM])
);

CREATE TABLE [Tratamento775799] (
	[CPF_Paciente] nvarchar(max) NOT NULL,
	[CRM_Medico] nvarchar(max) NOT NULL,
	[Responsavel] bit NOT NULL
);



ALTER TABLE [Tratamento775799] ADD CONSTRAINT [Tratamento775799_fk0] FOREIGN KEY ([CPF_Paciente]) REFERENCES [paciente775799]([CPF]);

ALTER TABLE [Tratamento775799] ADD CONSTRAINT [Tratamento775799_fk1] FOREIGN KEY ([CRM_Medico]) REFERENCES [medico775799]([CRM]);