# CRUD-BASICO-ESCUELA
Se desarrolla CRUD basico para escuela implementado con Java 11 y Spring Boot

Se utiliza como base de datos SQL Server

#Data Base

CREATE DATABASE school;

USE [school]
GO

/****** Object:  Table [dbo].[profesor]    Script Date: 22/08/2022 04:50:56 a. m. ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[profesor]') AND type in (N'U'))
DROP TABLE [dbo].[profesor]
GO

/****** Object:  Table [dbo].[profesor]    Script Date: 22/08/2022 04:50:56 a. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[profesor](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellido] [varchar](50) NOT NULL,
	[genero] [varchar](20) NULL,
 CONSTRAINT [PK_profesor] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


ALTER TABLE [dbo].[grado] DROP CONSTRAINT [FK_grado_profesor]
GO

/****** Object:  Table [dbo].[grado]    Script Date: 22/08/2022 04:50:46 a. m. ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[grado]') AND type in (N'U'))
DROP TABLE [dbo].[grado]
GO

/****** Object:  Table [dbo].[grado]    Script Date: 22/08/2022 04:50:46 a. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[grado](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
	[profesor_id] [int] NULL,
 CONSTRAINT [PK_grado] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[grado]  WITH CHECK ADD  CONSTRAINT [FK_grado_profesor] FOREIGN KEY([profesor_id])
REFERENCES [dbo].[profesor] ([id])
GO

ALTER TABLE [dbo].[grado] CHECK CONSTRAINT [FK_grado_profesor]
GO

/****** Object:  Table [dbo].[alumno_grado]    Script Date: 22/08/2022 04:49:06 a. m. ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[alumno_grado]') AND type in (N'U'))
DROP TABLE [dbo].[alumno_grado]
GO

/****** Object:  Table [dbo].[alumno_grado]    Script Date: 22/08/2022 04:49:06 a. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[alumno_grado](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[seccion] [varchar](20) NOT NULL,
	[alumno_id] [int] NOT NULL,
	[grado_id] [int] NOT NULL,
 CONSTRAINT [PK_alumno_grado] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[alumno_grado]  WITH CHECK ADD  CONSTRAINT [FK_alumno_grado_alumno] FOREIGN KEY([alumno_id])
REFERENCES [dbo].[alumno] ([id])
GO

ALTER TABLE [dbo].[alumno_grado] CHECK CONSTRAINT [FK_alumno_grado_alumno]
GO

ALTER TABLE [dbo].[alumno_grado]  WITH CHECK ADD  CONSTRAINT [FK_alumno_grado_grado] FOREIGN KEY([grado_id])
REFERENCES [dbo].[grado] ([id])
GO

ALTER TABLE [dbo].[alumno_grado] CHECK CONSTRAINT [FK_alumno_grado_grado]
GO


/****** Object:  Table [dbo].[alumno]    Script Date: 22/08/2022 04:50:05 a. m. ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[alumno]') AND type in (N'U'))
DROP TABLE [dbo].[alumno]
GO

/****** Object:  Table [dbo].[alumno]    Script Date: 22/08/2022 04:50:05 a. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[alumno](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellido] [varchar](50) NOT NULL,
	[genero] [varchar](20) NULL,
	[fecha_nacimiento] [varchar](20) NULL,
 CONSTRAINT [PK_alumno] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
