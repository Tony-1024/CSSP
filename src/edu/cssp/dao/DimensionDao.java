package edu.cssp.dao;

import java.io.Serializable;
import java.util.List;

import edu.cssp.beans.Dimension;

public interface DimensionDao {
	public Serializable addDimension(Dimension dim);

	public List<Dimension> getAllDimensions();

	public void updateDimension(Dimension dim);
}