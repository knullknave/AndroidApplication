public void BD_backup() throws IOException
{
        final String inFileName = "/data/data/com.example.ainoa.proyectoweloveyou/databases/"+DATABASE_NAME;
        File dbFile = new File(inFileName);
        FileInputStream fis = null;

        fis = new FileInputStream(dbFile);

        String directorio = "/sdcard/Download";
        File d = new File(directorio);
        if (!d.exists())
		{
            d.mkdir();
        }
        String outFileName = directorio + "/"+DATABASE_NAME;

        OutputStream output = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0)
		{
            output.write(buffer, 0, length);
        }

        output.flush();
        output.close();
        fis.close();
}