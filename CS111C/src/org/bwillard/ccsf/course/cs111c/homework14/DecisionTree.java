package org.bwillard.ccsf.course.cs111c.homework14;

import java.util.Iterator;

public class DecisionTree<T> implements DecisionTreeInterface<T> {

	public DecisionTree(T rootData) {
		setTree(rootData);
	}
	
	
	@Override
	public void setTree(T rootData) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
			BinaryTreeInterface<T> rightTree) {
		// TODO Auto-generated method stub

	}

	@Override
	public T getRootData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<T> getPreorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getCurrentData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentData(T newData) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAnswers(T answerForNo, T answerForYes) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isAnswer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void advanceToNo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void advanceToYes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

}
