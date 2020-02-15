	/**
	 * Save image of graphics container as img.png.
	 * 
	 * @throws IOException
	 */
	private BufferedImage saveImage() throws IOException {
		BufferedImage image = new BufferedImage(graphicsContainer.getPreferredSize().width,
				graphicsContainer.getPreferredSize().height, BufferedImage.TYPE_INT_ARGB);
        
		Graphics g = image.getGraphics();
		graphicsContainer.paint(g);
    
		ImageIO.write(image, "png", new File("savedImage.png"));
		return image;
	}
  
  	/**
	 * Save image of graphics container as img.jpg.
	 * 
	 * @throws IOException
	 */
	private BufferedImage saveImage() throws IOException {
		BufferedImage image = new BufferedImage(graphicsContainer.getPreferredSize().width,
				graphicsContainer.getPreferredSize().height, BufferedImage.TYPE_INT_ARGB);
        
		Graphics g = image.getGraphics();
		graphicsContainer.paint(g);
    
		ImageIO.write(image, "jpg", new File("savedImage.jpg"));
		return image;
	}

  	/**
	 * serialize the img object.
	 */
	public static void preprocessImg(byte[] img, ParseException e) {
		if (e == null) {
			Bitmap b = byteArrayToBitmap(img);
			callback.onImageReceived(null, b);
		} else {
			callback.onImageReceived(e, null);
		}
	}
  
  
